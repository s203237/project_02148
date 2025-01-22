import React, { useState, useEffect } from "react";

const EventList = ({ date }) => {
    const [events, setEvents] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);

    useEffect(() => {
        // Hàm lấy dữ liệu sự kiện từ API
        const fetchEvents = async () => {
            try {
                const response = await fetch("http://localhost:8080/api/events");
                if (!response.ok) throw new Error("Failed to fetch events");
                const data = await response.json();
                setEvents(data); // Gán dữ liệu lấy được vào state
                setLoading(false);
            } catch (err) {
                setError(err.message);
                setLoading(false);
            }
        };

        fetchEvents();
    }, []);

    // Lọc sự kiện theo ngày
    const eventsForDate = events.filter(
        (event) => new Date(event.date).toDateString() === date.toDateString()
    );

    if (loading) return <p>Loading events...</p>;
    if (error) return <p>Error: {error}</p>;

    return (
        <ul>
            {eventsForDate.length > 0 ? (
                eventsForDate.map((event) => (
                    <li key={event.id}>
                        <strong>{event.title}</strong>
                    </li>
                ))
            ) : (
                <li>No events</li>
            )}
        </ul>
    );
};
export default EventList;
