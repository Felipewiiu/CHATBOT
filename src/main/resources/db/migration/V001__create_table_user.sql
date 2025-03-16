CREATE TABLE IF NOT EXISTS users (
    id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    phone_Number VARCHAR(20) UNIQUE NOT NULL,
    is_agent BOOLEAN,
    created_at TIMESTAMP
);