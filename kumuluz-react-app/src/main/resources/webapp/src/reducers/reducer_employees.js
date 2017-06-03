import _ from 'lodash';
import {FETCH_EMPLOYEES} from '../actions';
import {CREATE_EMPLOYEE} from '../actions';
import {FETCH_EMPLOYEE} from '../actions';

export default function(state = {}, action) {
    switch (action.type) {
        case FETCH_EMPLOYEES:
            return _.mapKeys(action.payload.data, 'id');
        case FETCH_EMPLOYEE:
            return {...state, [action.payload.data.id]: action.payload.data};
        default:
            return state;
    }
}