import React, { useState } from "react";

const WeekView = () => {
    const [week, setWeek] = useState(getCurrentWeek()); // Lấy tuần hiện tại

    return (
        <div>
            <h2>Tuần hiện tại</h2>
            <div style={{ display: "grid", gridTemplateColumns: "repeat(7, 1fr)" }}>
                {week.map((day) => (
                    <div key={day} style={{ border: "1px solid #ddd", padding: "10px" }}>
                        <h3>{formatDate(day)}</h3>
                        {/* Hiển thị sự kiện của ngày */}
                        <EventList date={day} />
                    </div>
                ))}
            </div>
        </div>
    );
};

// Hàm trợ giúp: Tính tuần hiện tại
const getCurrentWeek = () => {
    const today = new Date();
    const firstDayOfWeek = new Date(today.setDate(today.getDate() - today.getDay())); // Chủ nhật
    return Array.from({ length: 7 }, (_, i) => new Date(firstDayOfWeek.setDate(firstDayOfWeek.getDate() + i)));
};

// Hàm trợ giúp: Format ngày
const formatDate = (date) => date.toLocaleDateString("en-US", { weekday: "short", day: "numeric" });

export default WeekView;
