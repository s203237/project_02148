import React, { useState } from "react";
import CalendarView from "../components/CalendarView";

const MonthView = () => {
    const [selectedDate, setSelectedDate] = useState(new Date());

    const handleDateChange = (date) => {
        setSelectedDate(date);
        console.log("Selected date:", date);
    };

    return (
        <div
            style={{
                display: "flex",
                flexDirection: "column",
                height: "100%",
                padding: "20px",
                boxSizing: "border-box",
            }}
        >
            <h2 style={{ textAlign: "center", marginBottom: "20px" }}>Monthly Calendar</h2>
            <div style={{ flex: 1 }}>
                <CalendarView
                    selectedDate={selectedDate}
                    onDateChange={handleDateChange}
                />
            </div>
        </div>
    );
};

export default MonthView;

