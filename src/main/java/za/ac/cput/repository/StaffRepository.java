package za.ac.cput.repository;

import za.ac.cput.entity.Staff;

import java.util.HashSet;
import java.util.Set;

public class StaffRepository implements StaffRepositoryInterface {

    private static StaffRepository staffRepository= null;
    private Set<Staff> st;

    private StaffRepository(){
        st= new HashSet<Staff>();
    }

    public static StaffRepository getInstance(){
        if (staffRepository== null){
            staffRepository= new StaffRepository();
        }
        return staffRepository;
    }
    @Override
    public Staff create(Staff staff) {
        boolean success = st.add(staff);

        if (!success){
            return null;
        }
        return staff;
    }

    @Override
    public Staff read(Long staffID) {
        for (Staff staff: st){
            if (staff.getStaffMember_ID()== staffID){
                return staff;
            }
        }
        return null;
    }


    @Override
    public Staff update(Staff staff) {
        Staff oldStaff = read(staff.getStaffMember_ID());
        if (oldStaff !=null){
            st.remove(oldStaff);
            st.add(staff);
            return staff;
        }
        return null;
    }

    @Override
    public boolean delete(Long staffId) {
        Staff deleteStaff = read(staffId);

        if (deleteStaff== null){
            return false;
        }
        st.remove(deleteStaff);
        return true;
    }


    @Override
    public Set<Staff> getAll() {
        return st;
    }
}
