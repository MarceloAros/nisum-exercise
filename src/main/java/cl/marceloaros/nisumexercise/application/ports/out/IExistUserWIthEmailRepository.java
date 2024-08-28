package cl.marceloaros.nisumexercise.application.ports.out;

public interface IExistUserWIthEmailRepository {
    Boolean existUserWithEmail(String email);
}
