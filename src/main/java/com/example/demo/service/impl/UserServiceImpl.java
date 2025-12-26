@Override
public User register(User user) {
    // Call your existing registration logic here
    return userRepository.save(user); 
}