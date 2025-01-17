import { registerUser, loginUser, getUser, updateUser, deleteUser } from "./services/userService";

const testAPI = async () => {
    try {
        // 1. Đăng ký người dùng mới
        const registerResponse = await registerUser({
            email: "test@example.com",
            name: "Test User",
            password: "password123",
        });
        console.log("Register:", registerResponse);

        // 2. Đăng nhập người dùng
        const loginResponse = await loginUser({
            email: "test@example.com",
            password: "password123",
        });
        console.log("Login:", loginResponse);

        // 3. Lấy thông tin người dùng
        const userInfo = await getUser("test@example.com");
        console.log("User Info:", userInfo);

        // 4. Cập nhật thông tin người dùng
        const updateResponse = await updateUser("test@example.com", {
            name: "Updated User",
            password: "newpassword123",
        });
        console.log("Update:", updateResponse);

        // 5. Xóa người dùng
        const deleteResponse = await deleteUser("test@example.com");
        console.log("Delete:", deleteResponse);
    } catch (error) {
        console.error("API Error:", error.message);
    }
};

testAPI();
