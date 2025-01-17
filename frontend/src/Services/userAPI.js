import axios from "axios";

        const API_URL = "http://localhost:8080/api/users";
        // Register new user
        export const registerUser = async (user) => {
                try {
                        const response = await axios.post(`${API_URL}/register`, user);
                        return response.data;
                } catch (error) {
                        throw new Error(error.response.data || "Failed to register user.");
                }
        };
        // User login
        export const loginUser = async (credentials) => {
                try {
                        const response = await axios.post(`${API_URL}/login`, credentials);
                        return response.data;
                } catch (error) {
                        throw new Error(error.response.data || "Failed to login.");
                }
        };
        // Get  users
        export const getUsers = async (email) => {
                try {
                        const response = await axios.get(`${API_URL}/${email}`);
                        return response.data;
                } catch (error) {
                        throw new Error(error.response.data || "Failed to get user.");
                }
        };


        // Add new user
        export const updateUser = async (email, updateUser) => {
                try{
                        const response = await axios.post(`${API_URL}/${email}`, updateUser);
                        return response.data;
                } catch (error) {
                throw new Error(error.response.data || "Failed to update user.");
                }
        };
        // delete user
        export const deleteUser = async (email) => {
                try {
                        const response = await axios.delete(`${API_URL}/${email}`);
                        return response.data;
                } catch (error) {
                        throw new Error(error.response.data || "Failed to delete user.");
                }
        };
