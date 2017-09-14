package softuni.commands;


import softuni.models.bindingModels.user.RegisterUser;
import softuni.service.api.GameService;
import softuni.service.api.UserService;
import softuni.utils.DataParser;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class RegisterCommand extends Command{

    public RegisterCommand(UserService userService, GameService gameService) {
        super(userService, gameService);
    }

    @Override
    public String execute(String... params) {
        RegisterUser registerUser = new RegisterUser();

            registerUser.setEmail(params[0]);
            registerUser.setPassword(params[1]);
            registerUser.setConfirmPassword(params[2]);
            registerUser.setFullName(params[3]);


            if(!DataParser.checkIsValid(registerUser)){
                return DataParser.getInvalidParameterMessage(registerUser);
            }

            try{
                super.getUserService().persist(registerUser);
            } catch (IllegalStateException e){
                return e.getMessage();
        }



        return String.format("%s was registered",params[3]);
    }
}
