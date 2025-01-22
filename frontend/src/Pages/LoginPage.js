import { useState } from "react";
import { useNavigate } from "react-router-dom";

function LoginPage({onLogin}) {
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [error, setError] = useState(false);
    const navigate = useNavigate();
    const handleSubmit = async (e) => {
        e.preventDefault();
        setError(null);
        try{
        const response = await fetch("http://localhost:8080/api/users/login", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({ email, password }),
        });

            if (response.ok) {
                const data = await response.json();
                alert("Login successful!");
                onLogin();
                navigate("/main");
            } else {
                setError(true);
            }
        } catch (err) {
            setError(true);
        }
    };
    return (
        <div style={{ maxWidth: "400px", margin: "0 auto", padding: "20px" }}>
            <h1>Login</h1>
            <form onSubmit={handleSubmit} style={{ display: "flex", flexDirection: "column", gap: "10px" }}>
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
                <button
                    type="submit"
                    style={{
                        padding: "10px",
                        backgroundColor: "#4CAF50",
                        color: "white",
                        border: "none",
                        cursor: "pointer",
                    }}
                >
                    Login
                </button>
            </form>

            {/* Show "Retry" and "Rewrite" sections when there is an error */}
            {error ? (
                <div style={{ marginTop: "20px", textAlign: "center" }}>
                    <button
                        style={{
                            padding: "10px",
                            marginBottom: "10px",
                            backgroundColor: "#f4b136",
                            color: "white",
                            border: "none",
                            cursor: "pointer",
                        }}
                        onClick={() => setError(false)}
                    >
                        Retry Login
                    </button>

                    <div>
                        <p>Do you want to recreate an account?</p>
                        <button
                            style={{
                                padding: "10px",
                                backgroundColor: "#2196F3",
                                color: "white",
                                border: "none",
                                cursor: "pointer",
                            }}
                            onClick={() => navigate("/register")}
                        >
                            Sign Up
                        </button>
                    </div>
                </div>
            ) : (
                <div style={{ marginTop: "20px", textAlign: "center" }}>
                    <p>Do you want to create an account?</p>
                    <button
                        style={{
                            padding: "10px",
                            backgroundColor: "#2196F3",
                            color: "white",
                            border: "none",
                            cursor: "pointer",
                        }}
                        onClick={() => navigate("/register")}
                    >
                    Sign Up
                    </button>
                </div>
            )}
        </div>
    );
}

export default LoginPage;
