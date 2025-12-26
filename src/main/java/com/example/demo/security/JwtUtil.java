// Keep this for the tests!
    public JwtUtil(String secretKey, int expirationMillis) {
        this.secretKey = secretKey;
        this.expirationMillis = expirationMillis;
    }

    public String generateToken(User user) {
        return generateToken(user.getId(), user.getEmail(), user.getRole());
    }