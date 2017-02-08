package ru.techcoll.saranskquiz.model;


import android.util.Log;
import android.widget.ArrayAdapter;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FireBaseDataStorage<T> {

    private final Class<T> typeParameterClass;

    public FireBaseDataStorage(Class<T> typeParameterClass){
        this.typeParameterClass = typeParameterClass;
    }

    public void addContentFromFireBase(final ArrayList<T> list, List<String> tree){

       DatabaseReference reference = getReference(tree);
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ArrayList<T> arrayList = new ArrayList<>();

                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                    T object =   snapshot.getValue(typeParameterClass);
                    arrayList.add(object);
                    Log.e("Firebase", object.toString());
                }
                list.addAll(arrayList);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e("firebase", databaseError.toString());
            }
        });
    }


    private DatabaseReference getReference(List<String> tree){
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
        for(String node : tree) {
            reference = reference.child(node);
        }
        return reference;
    }


}
