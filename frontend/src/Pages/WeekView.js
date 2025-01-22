import React, { useState } from "react";
import EventList from "../components/EventList";


const WeekView = () => {
    const [week, setWeek] = useState(getCurrentWeek()); //Get current week
    const currentWeekNumber = getWeekNumber(new Date());
    return (
        <div>
            <h2>Week: {currentWeekNumber}</h2>
            <div style={{ display: "grid", gridTemplateColumns: "repeat(7, 1fr)" }}>
                {week.map((day) => (
                    <div key={day} style={{ border: "1px solid #ddd", padding: "10px" }}>
                        <h3>{formatDate(day)}</h3>
                        {/* Show events of the day */}
                        <EventList date={day} />
                    </div>
                ))}
            </div>
        </div>
    );
};

// Function: Calculate current week
const getCurrentWeek = () => {
    const today = new Date();
    const firstDayOfWeek = new Date(today.setDate(today.getDate() - today.getDay())); // Chủ nhật
    return Array.from({ length: 7 }, (_, i) => new Date(firstDayOfWeek.setDate(firstDayOfWeek.getDate() + i)));
};

// Function: Date format
const formatDate = (date) => date.toLocaleDateString("en-US", { weekday: "short", day: "numeric" });
const getWeekNumber = (date) => {
    const firstDayOfYear = new Date(date.getFullYear(), 0, 1); // First day of the year
    const daysPastSinceStartOfYear = Math.floor((date - firstDayOfYear) / (24 * 60 * 60 * 1000));
    return Math.ceil((daysPastSinceStartOfYear + firstDayOfYear.getDay() + 1) / 7);
};
export default WeekView;
