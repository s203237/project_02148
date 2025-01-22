import React, { useState } from "react";
import DayView from "./DayView";
import WeekView from "./WeekView";
import MonthView from "./MonthView";
import NavigationBar from "/Users/lynguyenhansen/Documents/GitHub/project_02148/frontend/src/components/NavigationBar.java";

const MainPage = () => {
    const [view, setView] = useState("day");

    return (
        <div>
            <div style={{ display: "flex" }}>
                <NavigationBar />

            <div style={{ display: "flex", justifyContent: "center", marginBottom: "20px" }}>

                <button onClick={() => setView("day")} style={{... buttonStyle, backgroundColor: "#F1ACB3"} }>
                    Day
                </button>
                <button onClick={() => setView("week")} style={{... buttonStyle, backgroundColor: "#7fd7fa"} }>
                    Week
                </button>
                <button onClick={() => setView("month")} style={{... buttonStyle, backgroundColor: "#fac37f"} }>
                    Month
                </button>
            </div>

            {/* Hiển thị giao diện tương ứng */}
            <div>
                {view === "day" && <DayView />}
                {view === "week" && <WeekView />}
                {view === "month" && <MonthView />}
            </div>
            </div>
        </div>
    );
};

// Style cho các nút
const buttonStyle = {
    padding: "10px 20px",
    margin: "0 10px",
    cursor: "pointer",
    backgroundColor: "#007bff",
    color: "#fff",
    border: "none",
    borderRadius: "5px",
};

export default MainPage;
