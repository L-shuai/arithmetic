package 算法基础.day03;

import java.util.*;

public class 三数之和 {

    public List<List<Integer>> threeSum2(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
//        枚举a
        for(int first = 0;first<n;first++){
//            需要和上一次枚举的不同
            if(first>0 && nums[first]==nums[first-1]){
                continue;
            }
//            c对应的指针为数组的最右端
            int third = n-1;
            int target = -nums[first];
//            枚举b
            for(int second = first+1;second<n;second++){
//                需要和上一次枚举的不同
                if(second>first+1 && nums[second]==nums[second-1]){
                    continue;
                }
//                需要保证b的指针在c的左侧
                while (second<third && nums[second]+nums[third]>target){
                    third--;
                }
//                如果b c重合
                if(second==third){
                    break;
                }
                if(nums[second]+nums[third]==target){
                    ans.add(new ArrayList<>(Arrays.asList(nums[first],nums[second],nums[third])));
                }
            }
        }
        return ans;
    }

    public List<List<Integer>> threeSum3(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
//        List<List<Integer>> ans = new ArrayList<>();
        Set<List<Integer>> ans = new HashSet<>();
        for(int i=0;i<n;i++){
            int left = i+1;
            int right=n-1;
            while (left<right){
                if(nums[i]+nums[left]+nums[right]==0){
                    ans.add(new ArrayList<Integer>(Arrays.asList(nums[i],nums[left],nums[right])));
                    left++;
                    right--;
                }else if(nums[i]+nums[left]+nums[right]<0){
                    left++;
                }
                else{
                    right--;
                }
            }
        }
        return new ArrayList<>(ans);
    }

//    public List<List<Integer>> threeSum(int[] nums) {
//        int n = nums.length;
//        Arrays.sort(nums);
//        Set<List<Integer>> ans = new HashSet<>();
//        for(int i=0;i<n;i++){
//            if(nums[i]>0){
//                break;
//            }
//            for(int j=i+1;j<n;j++){
//                if(nums[j]>0 && nums[i]>=0)
//                    break;
//                for(int k=j+1;k<n;k++){
//                    if(nums[i]+nums[j]+nums[k]==0){
//                        ans.add(new ArrayList<Integer>(Arrays.asList(nums[i],nums[j],nums[k])));
//                        break;
//                    }else if(nums[i]+nums[j]+nums[k]>0){
//                        break;
//                    }
//                }
//            }
//        }
//        return new ArrayList<>(ans);
//    }

}
