-- Add data to the users table
INSERT INTO public.users (name, email,password)
VALUES
    ('Alice', 'alice@example.com','$2a$10$encryptedpassword1'),
    ('Bob', 'bob@example.com','$2a$10$encryptedpassword2');

-- Add data to the tasks table
INSERT INTO public.tasks (title, description, date_time, priority, category, user_id)
VALUES
    ('Task 1', 'Description 1', '2025-01-16 09:00:00', 'High', 'Work', 1),
    ('Task 2', 'Description 2', '2025-01-17 10:00:00', 'Medium', 'Personal', 2);

-- Add data to the events table
INSERT INTO public.events (title, description, date_time, location, is_recurring, user_id)
VALUES
    ('Meeting', 'Project discussion', '2025-01-20 15:00:00', 'Office', TRUE, 1),
    ('Yoga Class', 'Weekly yoga session', '2025-01-22 07:00:00', 'Studio', TRUE, 2);
