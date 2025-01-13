import React from "react";
import Calendar from "react-calendar";
import "react-calendar/dist/Calendar.css";

const CalendarView = ({ selectedDate, onDateChange }) => {
    return <Calendar value={selectedDate} onChange={onDateChange} />;
};

export default CalendarView;
