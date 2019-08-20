package mj.apps.rxandroiddemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.ReplaySubject;

public class MainActivity extends AppCompatActivity {
    
    public static final String TAG = MainActivity.class.getSimpleName();
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ReplaySubject<Integer> replaySubject = ReplaySubject.create();
// It will get 1, 2, 3, 4
        replaySubject.subscribe(getFirstObserver());
        replaySubject.onNext(1);
        replaySubject.onNext(2);
        replaySubject.onNext(3);
        replaySubject.onNext(4);
        replaySubject.onComplete();
// It will also get 1, 2, 3, 4 as we have used replay Subject
        replaySubject.subscribe(getSecondObserver());
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
