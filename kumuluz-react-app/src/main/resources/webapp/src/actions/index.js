import axios from "axios";

export const FETCH_EMPLOYEES = 'fetch_employees';
export const FETCH_EMPLOYEE = 'fetch_employee';
export const CREATE_EMPLOYEE = 'create_employee';

const ROOT_URL = 'http://localhost:3300/rest';

export function fetchEmployees() {

    const request = axios.get(`${ROOT_URL}/employees`);

    return {
        type: FETCH_EMPLOYEES,
        payload: request
    };
}

export function createEmployee(values, callback) {

    const request = axios.post(`${ROOT_URL}/employees`, values)
        .then(() => callback());

    return {
        type: CREATE_EMPLOYEE,
        payload: request
    };
}

export function fetchEmployee(id) {

    const request = axios.get(`${ROOT_URL}/employees/${id}`);

    return {
        type: FETCH_EMPLOYEE,
        payload: request
    };
}