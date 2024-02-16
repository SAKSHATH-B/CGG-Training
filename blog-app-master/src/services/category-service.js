import { myAxios } from "./helper"
export const  loadingAllCategories=()=>{
  return myAxios.get('/categories/').then(
        (response)=>{
           console.log(response)
           return response.data
        }
    )
}