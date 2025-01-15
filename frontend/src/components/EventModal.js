import React, {useEffect, useState} from "react";

const EventModal = ({ isOpen, onClose, onSave, eventData }) => {
    // Status for event information fields
    const [title, setTitle] = useState(eventData?.title || "");
    const [description, setDescription] = useState(eventData?.description || "");
    const[location, setLocation]=useState(eventData?.location||"");
    const [startTime, setStartTime] = useState(eventData?.startTime || "");
    const [endTime, setEndTime] = useState(eventData?.endTime || "");

    useEffect(() => {
        if (eventData){
            setTitle(eventData.title);
            setDescription(eventData.description);
            setLocation(eventData.location);
            setStartTime(eventData.startTime);
            setEndTime(eventData.endTime);
        }else {
            setTitle("");
            setDescription("");
            setLocation("");
            setStartTime("");
            setEndTime("");
        }

    }, [eventData]);
    const handleSave = () => {
        const newEvent = { title, description,location, startTime, endTime };
        onSave(newEvent); // function callback to save event
        onClose(); // close modal after save
    };

    // If the modal is not open, nothing is rendered.
    if (!isOpen) return null;

    return (
        <div style={overlayStyle}>
            <div style={modalStyle}>
                <h2>{eventData ? "Edit" : "Add"}</h2>
                <form onSubmit={(e) => e.preventDefault()}>
                    <div style={formGroupStyle}>
                        <label>Title</label>
                        <input
                            type="text"
                            value={title}
                            onChange={(e) => setTitle(e.target.value)}
                            required
                        />
                    </div>
                    <div style={formGroupStyle}>
                        <label>Description </label>
                        <textarea
                            value={description}
                            onChange={(e) => setDescription(e.target.value)}
                        />
                    </div>
                    <div style={formGroupStyle}>
                        <label>Location </label>
                        <textarea
                            value={location}
                            onChange={(e) => setLocation(e.target.value)}
                        />
                    </div>
                    <div style={formGroupStyle}>
                        <label>Start time </label>
                        <input
                            type="datetime-local"
                            value={startTime}
                            onChange={(e) => setStartTime(e.target.value)}
                            required
                        />
                    </div>
                    <div style={formGroupStyle}>
                        <label>End time </label>
                        <input
                            type="datetime-local"
                            value={endTime}
                            onChange={(e) => setEndTime(e.target.value)}
                            required
                        />
                    </div>
                    <div style={buttonGroupStyle}>
                        <button type="button" onClick={onClose} style={buttonStyle}>
                            Cancel
                        </button>
                        <button type="button" onClick={handleSave} style={buttonStyle}>
                           Save
                        </button>
                    </div>
                </form>
            </div>
        </div>
    );
};

// CSS
const overlayStyle = {
    position: "fixed",
    top: 0,
    left: 0,
    right: 0,
    bottom: 0,
    backgroundColor: "rgba(0, 0, 0, 0.5)",
    display: "flex",
    justifyContent: "center",
    alignItems: "center",
    zIndex: 1000,
};

const modalStyle = {
    backgroundColor: "#fff",
    padding: "20px",
    borderRadius: "8px",
    width: "400px",
    boxShadow: "0 2px 10px rgba(0, 0, 0, 0.1)",
};

const formGroupStyle = {
    marginBottom: "15px",
};

const buttonGroupStyle = {
    display: "flex",
    justifyContent: "flex-end",
};

const buttonStyle = {
    marginLeft: "10px",
    padding: "10px 15px",
    border: "none",
    borderRadius: "5px",
    backgroundColor: "#007bff",
    color: "#fff",
    cursor: "pointer",
};

export default EventModal;
