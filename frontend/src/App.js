import React from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import MainPage from "./Pages/MainPage";

function App() {
    return (
        <Router>
            <Routes>
                {/* Mặc định hiển thị MainPage */}
                <Route path="/" element={<MainPage />} />
            </Routes>
        </Router>
    );
}

export default App;
