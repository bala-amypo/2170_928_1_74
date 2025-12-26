@Override
    public User register(User user) { return userRepository.save(user); }

    @Override
    public User registerUser(User user) { return register(user); }

    @Override
    public User findByEmail(String email) { return userRepository.findByEmail(email).orElse(null); }