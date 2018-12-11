package com.example.jenniferniang.karatetournament_app.general;

import android.support.annotation.NonNull;
import android.support.v7.recyclerview.extensions.ListAdapter;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jenniferniang.karatetournament_app.R;
import com.example.jenniferniang.karatetournament_app.db.Event;
import com.example.jenniferniang.karatetournament_app.db.Register;

public class RegisterAdapter extends ListAdapter<Register, RegisterAdapter.RegisterHolder> {

    private RegisterAdapter.OnItemClickListener listener;

    public RegisterAdapter() {
        super(DIFF_CALLBACK);
    }

    private static final DiffUtil.ItemCallback<Register> DIFF_CALLBACK = new DiffUtil.ItemCallback<Register>() {
        @Override
        public boolean areItemsTheSame(Register oldItem, Register newItem) {
            return oldItem.getUserID() == newItem.getUserID();
        }

        @Override
        public boolean areContentsTheSame(Register oldItem, Register newItem) {
            return oldItem.getUserName().equals(newItem.getUserName()) &&
                    oldItem.getLastName().equals(newItem.getLastName()) &&
                    oldItem.getFirstName() == (newItem.getFirstName()) &&
                    oldItem.getDelegRole() == (newItem.getDelegRole()) &&
                    oldItem.getAge() == (newItem.getAge()) &&
                    oldItem.getGender() == (newItem.getGender()) &&
                    oldItem.getCity() == (newItem.getCity()) &&
                    oldItem.getCountry() == (newItem.getCountry()) &&
                    oldItem.getZipCode() == (newItem.getZipCode()) &&
                    oldItem.getWeight() == (newItem.getWeight()) &&
                    oldItem.getExperience() == (newItem.getExperience()) &&
                    oldItem.getClubID() == (newItem.getClubID()) &&
                    oldItem.getInstructorLastName() == (newItem.getInstructorLastName()) &&
                    oldItem.getRegisterPic() == newItem.getRegisterPic();

        }
    };

    @NonNull
    @Override
    public RegisterAdapter.RegisterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.register_item, parent, false);
        return new RegisterAdapter.RegisterHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RegisterAdapter.RegisterHolder holder, int position) {
        Register currentRegister = getItem(position);
        holder.tvUserName.setText(currentRegister.getUserName());
        holder.tvLastName.setText(currentRegister.getLastName());
        holder.tvFirstName.setText(currentRegister.getFirstName());
        holder.tvDelegRole.setText(currentRegister.getDelegRole());
        holder.tvAge.setText(currentRegister.getAge());
        holder.tvGender.setText(currentRegister.getGender());
        holder.tvCity.setText(currentRegister.getCity());
        holder.tvCountry.setText(currentRegister.getCountry());
        holder.tvZipCode.setText(currentRegister.getZipCode());
        holder.tvWeight.setText(currentRegister.getWeight());
        holder.tvExperience.setText(currentRegister.getExperience());
        holder.tvClubID.setText(currentRegister.getClubID());
        holder.tvInstructorLastName.setText(currentRegister.getInstructorLastName());
        holder.tvRegisterPic.setText(currentRegister.getRegisterPic());

    }

    public Register getRegisterAt(int position) {
        return getItem(position);
    }

    class RegisterHolder extends RecyclerView.ViewHolder {

        private TextView tvUserName;
        private TextView tvLastName;
        private TextView tvFirstName;
        private TextView tvDelegRole;
        private TextView tvAge;
        private TextView tvGender;
        private TextView tvCity;
        private TextView tvCountry;
        private TextView tvZipCode;
        private TextView tvWeight;
        private TextView tvExperience;
        private TextView tvClubID;
        private TextView tvInstructorLastName;
        private TextView tvRegisterPic;


        public RegisterHolder(View itemView) {
            super(itemView);

            tvUserName = itemView.findViewById(R.id.tv_register_username);
            tvLastName = itemView.findViewById(R.id.tv_register_lastname);
            tvFirstName = itemView.findViewById(R.id.tv_register_firstname);
            tvDelegRole = itemView.findViewById(R.id.tv_register_role);
            tvAge = itemView.findViewById(R.id.tv_register_age);
            tvGender = itemView.findViewById(R.id.tv_gender);
            tvCity = itemView.findViewById(R.id.tv_register_city);
            tvCountry = itemView.findViewById(R.id.tv_register_country);
            tvZipCode = itemView.findViewById(R.id.tv_register_zipcode);
            tvWeight = itemView.findViewById(R.id.tv_register_weight);
            tvExperience = itemView.findViewById(R.id.tv_register_experience);
            tvClubID = itemView.findViewById(R.id.tv_register_clubID);
            tvInstructorLastName = itemView.findViewById(R.id.tv_register_instructorLastName);
            tvRegisterPic = itemView.findViewById(R.id.tv_register_registerPic);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (listener != null && position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(getItem(position));
                    }
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(Register register);
    }

    public void setOnItemClickListener(RegisterAdapter.OnItemClickListener listener) {
        this.listener = listener;
    }

}
