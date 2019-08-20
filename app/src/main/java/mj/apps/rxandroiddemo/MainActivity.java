package mj.apps.rxandroiddemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.BehaviorSubject;

public class MainActivity extends AppCompatActivity {
    
    public static final String TAG = MainActivity.class.getSimpleName();
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BehaviorSubject<Integer> behaviorSubject = BehaviorSubject.create();
        // It will get 1, 2, 3, 4 and onComplete
        behaviorSubject.subscribe(getFirstObserver());
        behaviorSubject.onNext(1);
        behaviorSubject.onNext(2);
        behaviorSubject.onNext(3);
        // It will get 3(last emitted)and 4(subsequent item) and onComplete
        behaviorSubject.subscribe(getSecondObserver());
        behaviorSubject.onNext(4);
        behaviorSubject.onComplete();
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
