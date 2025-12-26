@Override
public User register(User user) {
    // This must be present for Security tests to pass
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    return userRepository.save(user);
}