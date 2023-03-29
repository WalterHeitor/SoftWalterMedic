package br.com.softwalter.med.api.doumain.usecase;

import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class UseCaseExecutorImpl implements UseCaseExecutor {

    @Override
    public <RX, I extends UseCase.InputValues, O extends UseCase.OutputValues> RX execute(
            UseCase<I, O> useCase, I input, Function<O, RX> outputMapper) {
        return outputMapper.apply(useCase.execute(input));
    }
}
