import React, { useState } from "react";
import DayView from "./DayView";
import WeekView from "./WeekView";
import MonthView from "./MonthView";

const MainPage = () => {
    const [view, setView] = useState("day"); // Giá trị mặc định là "day"

    return (
        <div>
            {/* Thanh chọn chế độ hiển thị */}
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
