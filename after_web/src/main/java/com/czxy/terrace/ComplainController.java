package com.czxy.terrace;

import com.czxy.terrace.service.ComplainService;
import com.czxy.tobto.dao.TComplainMapper;
import com.czxy.tobto.dao.UserMapper;
import com.czxy.tobto.domain.ES.EsTAdvertising;
import com.czxy.tobto.domain.ES.EsTComplain;
import com.czxy.tobto.domain.TComplain;
import com.czxy.utils.DataGridResult;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/terrace")
public class ComplainController {

    @Resource
    private ComplainService complainService;

    @GetMapping("/findComByPage")
    public ResponseEntity<DataGridResult> findAdvByPage(EsTComplain esTComplain, Integer page, Integer rows) {
        Page<EsTComplain> proByPage = complainService.findComByPage(esTComplain.getComplainText(), page, rows);
        System.out.println(esTComplain.getComplainState());

        DataGridResult result = new DataGridResult();
        result.setTotal(proByPage.getTotalElements());
        result.setRows(proByPage.getContent());

        return  new ResponseEntity<>(result, HttpStatus.OK);
    }
    /**
     * 添加
     * MultipartFile
     * @param complain
     * @return
     */
    @GetMapping("/addCom")
    public ResponseEntity<Void> addAdv(TComplain complain) {

        Integer num = this.complainService.addAdv(complain);
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
    @GetMapping("/deletesCom")
    public ResponseEntity<Void> deleteCom(String ids){
        Integer num=    this.complainService.deleteCom(ids);
        if (num!=null) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * 修改
     * @param complain
     * @return
     */
    @GetMapping("/updateCom")
    public ResponseEntity<Void> updateCom(TComplain  complain){
        Integer num = complainService.updateCom(complain);
        if (num==1 && num !=null) {
            return  new ResponseEntity<>(HttpStatus.CREATED);
        }

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
