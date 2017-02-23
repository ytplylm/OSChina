package com.domain.interactor.main;

import com.domain.bean.ShakeNews;
import com.domain.bean.SoftwareList;
import com.domain.executor.PostExecutionThread;
import com.domain.executor.ThreadExecutor;
import com.domain.interactor.UseCase;
import com.domain.repository.MainRepository;

import javax.inject.Inject;

import rx.Observable;

/**
 * @author op
 * @version 1.0
 * @description
 * @createDate 2016/11/14
 */
public class ShakeUseCase extends UseCase<ShakeNews> {
    MainRepository repository;

    @Inject
    public ShakeUseCase(MainRepository repository, ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.repository = repository;
    }

    @Override
    protected Observable<ShakeNews> buildUseCaseObservable() {
        return repository.getShake();
    }
}
