// import React, { useState } from "react";
// import axios from "axios";
//
// const LoginPage = () => {
//     const [username, setUsername] = useState("");
//     const [password, setPassword] = useState("");
//     const [error, setError] = useState("");
//
//     const handleLogin = async (e) => {
//         e.preventDefault();
//         try {
//             const response = await axios.post("http://localhost:8080/api/login", {
//                 username,
//                 password,
//             });
//             localStorage.setItem("token", response.data.token); // Lưu token
//             window.location.href = "/events"; // Chuyển đến màn hình sự kiện
//         } catch (err) {
//             setError("Sai tài khoản hoặc mật khẩu!");
//         }
//     };
//
//     return (
//         <div>
//             <h2>Đăng nhập</h2>
//             <form onSubmit={handleLogin}>
//                 <div>
//                     <label>Tên đăng nhập:</label>
//                     <input
//                         type="text"
//                         value={username}
//                         onChange={(e) => setUsername(e.target.value)}
//                         required
//                     />
//                 </div>
//                 <div>
//                     <label>Mật khẩu:</label>
//                     <input
//                         type="password"
//                         value={password}
//                         onChange={(e) => setPassword(e.target.value)}
//                         required
//                     />
//                 </div>
//                 {error && <p style={{ color: "red" }}>{error}</p>}
//                 <button type="submit">Đăng nhập</button>
//             </form>
//             <p>
//                 Chưa có tài khoản? <a href="/register">Đăng ký</a>
//             </p>
//         </div>
//     );
// };
//
// export default LoginPage;
