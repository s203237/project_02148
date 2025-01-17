import axios from "axios";

const API_URL = "http://localhost:8080/api/tasks";

// Get list of tasks
export const getAllTasks = async () => {
    const response = await axios.get(API_URL);
    return response.data;
};

// Add new task
export const createTask = async (task) => {
    const response = await axios.post(API_URL, task);
    return response.data;
};