import React from "react";
import Calendar from "react-calendar";
import "react-calendar/dist/Calendar.css";

const CalendarView = ({selectedDate, onDateChange, events = []}) => {
    const tileContent = ({date, view}) => {
        if (view === "month" && events) {
            const eventsForDate = events.filter(
                (event) => new Date(event.date).toDateString() === date.toDateString()
            );
            if (eventsForDate.length > 0) {

                return (
                    <div style={{marginTop: "5px"}}>
                        {eventsForDate.map((event) => (
                            <span
                                key={event.id}
                                style={{
                                    display: "block",
                                    backgroundColor: "#4caf50",
                                    color: "#fff",
                                    fontSize: "10px",
                                    padding: "2px",
                                    borderRadius: "4px",
                                    textAlign: "center",
                                }}
                            >
                                {event.title}
                            </span>
                        ))}
                    </div>
                );
            }
        }
        return null;
    };

    return (
        <Calendar
            value={selectedDate}
            onChange={onDateChange}
            tileContent={tileContent} // Mark event date
        />
    );
};

export default CalendarView;
