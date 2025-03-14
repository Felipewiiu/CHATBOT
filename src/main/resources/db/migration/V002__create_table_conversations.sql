CREATE TABLE IF NOT EXISTS conversations (
    id UUID PRIMARY KEY,
    user_one_id UUID NOT NULL,
    user_two_id UUID NOT NULL,
    created_at TIMESTAMP,
    FOREIGN KEY (user_one_id) REFERENCES users(id) ON DELETE CASCADE,
    FOREIGN KEY (user_two_id) REFERENCES users(id) ON DELETE CASCADE
);