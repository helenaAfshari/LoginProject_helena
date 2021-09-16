package com.example.loginproject_helena;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.loginproject_helena.model.ArtistModel;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterRecycler extends RecyclerView.Adapter<AdapterRecycler.viewHolderRecycler> {


  private Context context;
  List<ArtistModel>artistModels = new ArrayList<>();


  public AdapterRecycler(Context context,List<ArtistModel>dataModelArtistList)
  {
    this.context = context;
    this.artistModels = dataModelArtistList;
  }

  @NonNull
  @Override
  public viewHolderRecycler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyclerview,parent,false);
    return new viewHolderRecycler(view);
  }

  @Override
  public void onBindViewHolder(@NonNull viewHolderRecycler holder, int position) {
     holder.bind(artistModels.get(position));
  }


  @Override
  public int getItemCount() {
    return artistModels.size();
  }


  public void updateItem(ArtistModel model)
  {
    for (int i = 0; i <artistModels.size() ; i++) {
      if (model.getId() == artistModels.get(i).getId())
      {
        artistModels.set(i,model);
        notifyItemChanged(i);
      }
    }
  }

 public void deleteItem(ArtistModel model)
 {
   for (int i = 0; i <artistModels.size() ; i++) {
     if (model.getId() == artistModels.get(i).getId())
     {
       artistModels.remove(i);
       notifyItemRemoved(i);
       break;
     }
   }
 }


 //addکنیم ولی ما میخواییم ببینیم
  public void addDataItem(List<ArtistModel> models)
  {
    this.artistModels.addAll(models);
    notifyDataSetChanged();
  }


 public void loadRealTime(List<ArtistModel> list)
 {
   this.artistModels = list;
   notifyDataSetChanged();
 }
  
  public class viewHolderRecycler extends RecyclerView.ViewHolder
  {
    ImageView img_recy;
    TextView txtTitle;
    TextView txtContent;

    public viewHolderRecycler(@NonNull View itemView) {
      super(itemView);
      img_recy = itemView.findViewById(R.id.img_recy);
      txtTitle = itemView.findViewById(R.id.txtTitle);
      txtContent = itemView.findViewById(R.id.txtContent);
    }

    public void bind(ArtistModel artistModel)
    {
      Glide.with(itemView.getContext()).load(artistModel.getImage()).into(img_recy);
      txtTitle.setText(artistModel.getTitle());
      txtContent.setText(artistModel.getContent());
    }
  }


}
