import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
function Register() {
    const [name, setName] = useState("");
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const navigate = useNavigate();
    const [error, setError] = useState(null);
    const [success, setSuccess] = useState(false);
    const handleSubmit = async (e) => {
        e.preventDefault();
        setError(null);
        setSuccess(false);
        try{
        const response = await fetch("http://localhost:8080/api/users/register", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({ name, email, password }),
        });
            if (response.ok) {
                const data = await response.text();
                setSuccess(true);
                alert("Registration successful!");
                navigate("/login");
            }else{
                setError(errorMessage);
            }
        } catch(err){}
        setError("An unexpected error occurred. Please try again later.");
    };
return(
    <div style={{ maxWidth: "400px", margin: "0 auto", padding: "20px" }}>
        <h1>Register</h1>
        <form onSubmit={handleSubmit} style={{ display: "flex", flexDirection: "column", gap: "10px" }}>
            <input
                type="text"
                placeholder="Name"
                value={name}
                onChange={(e) => setName(e.target.value)}
                required
            />
            <input
                type="email"
                placeholder="Email"
                value={email}
                onChange={(e) => setEmail(e.target.value)}
                required
            />
            <input
                type="password"
                placeholder="Password"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
                required
            />
            <button type="submit" style={{ padding: "10px", backgroundColor: "#4CAF50", color: "white", border: "none", cursor: "pointer" }}>
                Register
            </button>
        </form>

        {error && (
            <div style={{ color: "red", marginTop: "10px" }}>
                <strong>Error:</strong> {error}
            </div>
        )}

        {success && (
            <div style={{ color: "green", marginTop: "10px" }}>
                Registration successful! Redirecting to login page...
            </div>
        )}
    </div>
);
}
export default Register;
