import React, { useState } from "react";
import axios from "axios";

const RegisterPage = () => {
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const [email, setEmail] = useState("");
    const [success, setSuccess] = useState(false);

    const handleRegister = async (e) => {
        e.preventDefault();
        try {
            await axios.post("http://localhost:8080/api/register", {
                username,
                password,
                email,
            });
            setSuccess(true);
        } catch (err) {
            console.error(err);
        }
    };

    return (
        <div>
            <h2>Đăng ký</h2>
            {success ? (
                <p>Đăng ký thành công! Hãy <a href="/">đăng nhập</a>.</p>
            ) : (
                <form onSubmit={handleRegister}>
                    <div>
                        <label>Tên đăng nhập:</label>
                        <input
                            type="text"
                            value={username}
                            onChange={(e) => setUsername(e.target.value)}
                            required
                        />
                    </div>
                    <div>
                        <label>Email:</label>
                        <input
                            type="email"
                            value={email}
                            onChange={(e) => setEmail(e.target.value)}
                            required
                        />
                    </div>
                    <div>
                        <label>Mật khẩu:</label>
                        <input
                            type="password"
                            value={password}
                            onChange={(e) => setPassword(e.target.value)}
                            required
                        />
                    </div>
                    <button type="submit">Đăng ký</button>
                </form>
            )}
        </div>
    );
};

export default RegisterPage;
