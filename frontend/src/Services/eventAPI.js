import axios from "axios";

const API_URL = "http://localhost:8080/api/events";

// get a list of events
export const getAllEvents = async () => {
    const response = await axios.get(API_URL);
    return response.data;
};

// add a new event
export const createEvent = async (event) => {
    const response = await axios.post(API_URL, event);
    return response.data;
};