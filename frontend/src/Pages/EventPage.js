// import React, { useState, useEffect } from "react";
// import axios from "axios";
//
// const EventPage = () => {
//     const [events, setEvents] = useState([]);
//     const [newEvent, setNewEvent] = useState("");
//
//     const fetchEvents = async () => {
//         const token = localStorage.getItem("token");
//         const response = await axios.get("http://localhost:8080/api/events", {
//             headers: { Authorization: `Bearer ${token}` },
//         });
//         setEvents(response.data);
//     };
//
//     const addEvent = async () => {
//         const token = localStorage.getItem("token");
//         await axios.post(
//             "http://localhost:8080/api/events",
//             { title: newEvent },
//             { headers: { Authorization: `Bearer ${token}` } }
//         );
//         setNewEvent("");
//         fetchEvents();
//     };
//
//     const deleteEvent = async (id) => {
//         const token = localStorage.getItem("token");
//         await axios.delete(`http://localhost:8080/api/events/${id}`, {
//             headers: { Authorization: `Bearer ${token}` },
//         });
//         fetchEvents();
//     };
//
//     useEffect(() => {
//         fetchEvents();
//     }, []);
//
//     return (
//         <div>
//             <h2>Quản lý sự kiện</h2>
//             <input
//                 type="text"
//                 value={newEvent}
//                 onChange={(e) => setNewEvent(e.target.value)}
//                 placeholder="Thêm sự kiện mới"
//             />
//             <button onClick={addEvent}>Thêm</button>
//             <ul>
//                 {events.map((event) => (
//                     <li key={event.id}>
//                         {event.title}{" "}
//                         <button onClick={() => deleteEvent(event.id)}>Xóa</button>
//                     </li>
//                 ))}
//             </ul>
//         </div>
//     );
// };
//
// export default EventPage;
