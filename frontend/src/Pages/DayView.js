import React, { useState } from "react";
import EventModal from "../components/EventModal";

const DayView = () => {
    const [isModalOpen, setIsModalOpen] = useState(false);
    const [events, setEvents] = useState([]);

    // Hàm mở modal
    const openModal = () => {
        setIsModalOpen(true);
    };

    // Hàm đóng modal
    const closeModal = () => {
        setIsModalOpen(false);
    };

    // Hàm lưu sự kiện
    const saveEvent = (newEvent) => {
        setEvents([...events, newEvent]); // Thêm sự kiện vào danh sách
    };

    return (
        <div>
            <h2>Hoạt động trong ngày</h2>
            <button onClick={openModal}>Thêm sự kiện</button>
            <ul>
                {events.map((event, index) => (
                    <li key={index}>{event.title}</li>
                ))}
            </ul>
            <EventModal
                isOpen={isModalOpen}
                onClose={closeModal}
                onSave={saveEvent}
            />
        </div>
    );
};

export default DayView;
