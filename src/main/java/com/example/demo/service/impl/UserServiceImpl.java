@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repo;
    private final PasswordEncoder encoder;

    public UserServiceImpl(UserRepository repo, PasswordEncoder encoder) {
        this.repo = repo;
        this.encoder = encoder;
    }

    public User registerUser(User user) {
        if (repo.existsByEmail(user.getEmail()))
            throw new IllegalArgumentException("Duplicate email");

        if (user.getRole() == null)
            user.setRole("USER");

        user.setPassword(encoder.encode(user.getPassword()));
        return repo.save(user);
    }
}
