import React from "react";

const EventList = ({ date }) => {
    return (
        <ul>
            {/* Render danh sách sự kiện */}
            <li>{`Sự kiện 1 vào ${date}`}</li>
            <li>{`Sự kiện 2 vào ${date}`}</li>
        </ul>
    );
};

export default EventList;
