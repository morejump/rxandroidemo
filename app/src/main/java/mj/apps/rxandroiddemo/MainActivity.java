package mj.apps.rxandroiddemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;

public class MainActivity extends AppCompatActivity {
    
    public static final String TAG = MainActivity.class.getSimpleName();
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PublishSubject<Integer> publishSubject = PublishSubject.create();
        
        // It will get 1, 2, 3, 4 and onComplete
        publishSubject.subscribe(getFirstObserver());
    
        publishSubject.onNext(1);
        publishSubject.onNext(2);
        publishSubject.onNext(3);
        
        // It will get 4 and onComplete for second observer also.
        publishSubject.subscribe(getSecondObserver());
    
        publishSubject.onNext(4);
        publishSubject.onComplete();
    }
    
    private Observer<Integer> getFirstObserver() {
        Observer<Integer> firstObserver = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
            
            }
            
            @Override
            public void onNext(Integer integer) {
                Log.d(TAG, "First " + integer);
            }
            
            @Override
            public void onError(Throwable e) {
            
            }
            
            @Override
            public void onComplete() {
            
            }
        };
        return firstObserver;
    }
    
    private Observer<Integer> getSecondObserver() {
        Observer<Integer> secondObserver = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
            
            }
            
            @Override
            public void onNext(Integer integer) {
                Log.d(TAG, "Second " + integer);
            }
            
            @Override
            public void onError(Throwable e) {
            
            }
            
            @Override
            public void onComplete() {
            
            }
        };
        return secondObserver;
    }
}
