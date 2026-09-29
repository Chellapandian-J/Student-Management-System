INSERT INTO students
(name, email, department, year_of_study)
VALUES
('Arun Kumar', 'arun@gmail.com', 'CSE', 4),
('Ravi Kumar', 'ravi@gmail.com', 'CSE', 4),
('Priya', 'priya@gmail.com', 'ECE', 3);
SELECT * FROM students;
INSERT INTO subjects
(subject_name, department)
VALUES
('Java Programming', 'CSE'),
('Database Management', 'CSE'),
('Computer Networks', 'CSE'),
('Digital Electronics', 'ECE');
SELECT * FROM subjects;
INSERT INTO attendance
(student_id, attendance_date, status)
VALUES
(3, '2026-09-29', 'Present'),
(3, '2026-09-30', 'Absent'),
(4, '2026-09-29', 'Present'),
(4, '2026-09-30', 'Present'),
(5, '2026-09-29', 'Present');
SELECT * FROM attendance;
INSERT INTO marks
(student_id, subject_id, marks)
VALUES
(3, 1, 85),
(3, 2, 90),
(3, 3, 78),

(4, 1, 75),
(4, 2, 82),
(4, 3, 80),

(5, 4, 88);
SELECT * FROM marks;
SELECT s.name,a.attendance_date,a.status
FROM students s
JOIN attendance a
ON s.student_id = a.student_id;
SELECT s.name,sub.subject_name,m.marks
FROM marks m
JOIN students s
    ON m.student_id = s.student_id
JOIN subjects sub
    ON m.subject_id = sub.subject_id;

SELECT s.student_id,s.name,
    COUNT(a.attendance_id) AS total_classes,
    SUM(a.status = 'Present') AS present_classes,
    ROUND(
        SUM(a.status = 'Present') * 100.0
        / COUNT(a.attendance_id),
        2
    ) AS attendance_percentage
FROM students s
JOIN attendance a
    ON s.student_id = a.student_id
GROUP BY s.student_id, s.name;