import axios from 'axios';
import { Customer } from '../types/Customer';

const apiUrl = "http://localhost:8080/api";

export async function getCustomers(): Promise<Customer[] | Error> {
    try {
        const response = await axios.get<Customer[]>(
            `${apiUrl}/customers`,
            {}
        );
        return response.data;
    } catch (error) {
        return new Error(`Unable to retrieve customers: (${String(error)}).`);
    }

}