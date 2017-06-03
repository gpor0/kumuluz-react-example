import React, {Component} from "react";
import {Field, reduxForm} from "redux-form";
import {Link} from 'react-router-dom';
import {connect} from 'react-redux';
import {createEmployee} from '../actions';

class EmployeesNew extends Component {

    renderField(field) {

        const { meta: {touched, error}} = field;
        const className = `form-group ${touched && error ? 'has-danger' : ''}`;

        return (
            <div className={className}>
                <label>{field.label}</label>
                <input
                    className="form-control"
                    type="text"
                    {...field.input}
                />
                <div className="text-help">
                    {touched ? error : ''}
                </div>
            </div>
        );
    }

    onSubmit(values) {
        this.props.createEmployee(values, () => {this.props.history.push('/');});
    }

    render() {
        const {handleSubmit} = this.props;

        return (
            <form onSubmit={handleSubmit(this.onSubmit.bind(this))}>
                <Field
                    label="First name"
                    name="firstName"
                    component={this.renderField}
                />
                <Field
                    label="Last name"
                    name="lastName"
                    component={this.renderField}
                />
                <button
                    type="submit"
                    className="btn btn-primary">Submit</button>
                <Link
                    to="/"
                    className="btn btn-danger">Cancel</Link>
            </form>
        );
    }
}

function validate(values) {
    console.log(values);
    const errors = {};

    if (!values.firstName) {
        errors.firstName = "Enter first name!";
    }

    if (!values.lastName) {
        errors.lastName = "Enter last name!";
    }

    return errors;
}

export default reduxForm({
    validate: validate,
    form: 'EmployeesNewForm'
})(
  connect(null, {createEmployee}) (EmployeesNew)
);