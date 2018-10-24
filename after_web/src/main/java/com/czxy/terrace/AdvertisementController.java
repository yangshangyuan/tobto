package com.czxy.terrace;


import com.czxy.terrace.service.AdvertisementService;
import com.czxy.tobto.domain.ES.EsTAdvertising;
import com.czxy.tobto.domain.TAdvertising;
import com.czxy.utils.DataGridResult;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/terrace")
public class AdvertisementController {

    @Autowired
    private AdvertisementService advertisementService;

    /**
     * es模糊查询,加分页
     * @param advertising
     * @param page
     * @param rows
     * @return
     */
    @GetMapping("/findAdvByPage")
    public ResponseEntity<DataGridResult> findAdvByPage(EsTAdvertising advertising, Integer page, Integer rows) {
        Page<EsTAdvertising> proByPage = advertisementService.findAdvByPage(advertising.getaText(), page, rows);
        System.out.println(advertising.getaText());

        DataGridResult result = new DataGridResult();
        result.setTotal(proByPage.getTotalElements());
        result.setRows(proByPage.getContent());

        return  new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * 添加
     * MultipartFile
     * @param advertising
     * @return
     */
    @GetMapping("/addAdv")
    public ResponseEntity<Void> addAdv(TAdvertising advertising) {

            Integer num = this.advertisementService.addAdv(advertising);
            if (num == 1) {
                return new ResponseEntity<>(HttpStatus.CREATED);
            }
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    /**
     * 删除
     * @param ids
     * @return
     */
    @GetMapping("/deletes")
    public ResponseEntity<Void> deleteAdv(String ids){
  Integer num=     this.advertisementService.deleteAdv(ids);
    if (num!=null) {
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
}

    @GetMapping("/update")
    public ResponseEntity<Void> updateProduct(TAdvertising  advertising){
        Integer num = this.advertisementService.updateAdvById(advertising);
        if (num==1) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
