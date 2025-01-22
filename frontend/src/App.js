import React,{ useState } from "react";
import { BrowserRouter as Router, Routes, Route, Navigate } from "react-router-dom";
import LoginPage from "./Pages/LoginPage";
import RegisterPage from "./Pages/RegisterPage";
import MainPage from "./Pages/MainPage";

function App() {
    const [isLoggedIn, setIsLoggedIn] = useState(false);
    return (
        <Router>
            <Routes>
                <Route path="/main" element={<MainPage />} />
                <Route path="/register" element={<RegisterPage />} />

                {/* Điều hướng mặc định về MainPage */}
                <Route path="*" element={<Navigate to="/main" />} />
                {/*<Route*/}
                {/*    path="/main"*/}
                {/*    element={isLoggedIn ? <MainPage /> : <Navigate to="/login" />}*/}
                {/*/>*/}

                {/*/!* Route to loginPage *!/*/}
                {/*<Route*/}
                {/*    path="/login"*/}
                {/*    element={<LoginPage onLogin={() => setIsLoggedIn(true)} />}*/}
                {/*/>*/}

                {/*/!* Route to Register *!/*/}
                {/*<Route path="/register" element={<RegisterPage />} />*/}

                {/*/!* Default Route: If no path, redirect to MainPage or LoginPage *!/*/}
                {/*<Route*/}
                {/*    path="*"*/}
                {/*    element={isLoggedIn ? <Navigate to="/main" /> : <Navigate to="/login" />}*/}
                {/*/>*/}
            </Routes>
        </Router>
    );
}

export default App;
