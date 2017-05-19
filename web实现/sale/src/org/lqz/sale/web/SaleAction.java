package org.lqz.sale.web;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.lqz.sale.domain.Good;
import org.lqz.sale.domain.Role;
import org.lqz.sale.domain.Sale;
import org.lqz.sale.domain.SaleGoods;
import org.lqz.sale.domain.User;
import org.lqz.sale.service.GoodService;
import org.lqz.sale.service.SaleGoodsService;
import org.lqz.sale.service.SaleService;
import org.lqz.sale.utils.Page;

import com.opensymphony.xwork2.ModelDriven;

public class SaleAction extends BaseAction implements ModelDriven<Sale> {

	private static final long serialVersionUID = 622530321511149132L;
	private Sale model = new Sale();
	@Override
	public Sale getModel() {
		return model;
	}

	// 分页查询
	private Page<Sale> page = new Page<Sale>();
	public Page<Sale> getPage() {
		return page;
	}
	public void setPage(Page<Sale> page) {
		this.page = page;
	}
	// 网页中商品名称和数量的属性[表格上方的两个表单]
	private SaleGoods saleGood = new SaleGoods();
	public void setSaleGood(SaleGoods saleGood) {
		this.saleGood = saleGood;
	}
	public SaleGoods getSaleGood() {
		return saleGood;
	}

	// 网页中添加的商品[表格中用]
	private Set<SaleGoods> pageGoods = new HashSet<SaleGoods>();
	public Set<SaleGoods> getPageGoods() {
		return pageGoods;
	}

	// 服务层
	private SaleService saleService;
	public void setSaleService(SaleService saleService) {
		this.saleService = saleService;
	}
	private GoodService goodService;
	public void setGoodService(GoodService goodService) {
		this.goodService = goodService;
	}
	private SaleGoodsService saleGoodsService;
	public void setSaleGoodsService(SaleGoodsService saleGoodsService) {
		this.saleGoodsService = saleGoodsService;
	}

	/**
	 * 分页查询
	 */
	public String list() throws Exception {
		String hql = "from Sale where delFlag = 0";
		saleService.findPage(hql, page, Sale.class, null);
//		List<Sale> sales = page.getResults();
//		for (Sale sale : sales) {
//			System.out.println("sale = " + sale);
//			for (SaleGoods saleGood : sale.getSaleGoods()) {
//				System.out.println("saleGood = " + saleGood
//						+ "good = "  + saleGood.getGood());
//			}
//		}
		// 设置分页的url地址
		page.setUrl("saleAction_list");

		// 将page对象压入栈顶
		super.push(page);
		return "list";
	}

	/**
	 * 查看
	 */
	public String toview() throws Exception {
		// 1.调用业务方法，根据id,得到对象
		Sale sale = saleService.get(Sale.class, model.getId());

		// 放入栈顶
		super.push(sale);

		// 3.跳页面
		return "toview";
	}

	/**
	 * 进入新增页面
	 */
	public String tocreate() throws Exception {
		// 1.创建一个新订单
		Role role = new Role();
		role.setId("402881625c20430b015c204690360000");
		User handler = new User();
		handler.setId("402881625c20430b015c2048f1fe0004");
		handler.setRole(role);
		model.setId(null);
		model.setHandler(handler);
		model.setDelFlag(0);
		saleService.saveOrUpdate(model);
		super.push(model);
		
		// 2.查询出所有商品
		List<Good> goods = goodService.find("from Good where delFlag=0", Good.class, null);
		super.put("goods", goods);
		
		return "tocreate";
	}
	
	/**
	 * 为销售单添加一个商品
	 * @return
	 */
	public String addOneGood() {
		
		// 查询出销售单
		Sale sale = saleService.get(Sale.class, model.getId());	
		
		// 查询出新增的货物
		Good good = goodService.get(Good.class, saleGood.getGood().getId());
		
		saleGood.setId(null);
		saleGood.setSale(sale);
		saleGood.setGood(good);
		saleGood.setGoodName(good.getName());
		
		// 得到该销售单下原有的货物
		pageGoods = sale.getSaleGoods();
		// 添加一条货物
		pageGoods.add(saleGood);
		sale.setSaleGoods(pageGoods);
		
		// 保存销售单
		saleService.saveOrUpdate(sale);
		super.put("results", pageGoods);
		
		// 查询出所有商品
		List<Good> goods = goodService.find("from Good where delFlag=0", Good.class, null);
		super.put("goods", goods);
		
		return "tocreate";
	}
	
	/*
	 * 删除销售单下的商品
	 */
	private String goodId;
	public void setGoodId(String goodId) {
		this.goodId = goodId;
	}
	public String deleteSaleGood_fromCreate(){
		deleteSaleGood();
		return "tocreate";
	}
	public String deleteSaleGood_fromUpdate(){
		deleteSaleGood();
		return "toupdate";
	}
	private void deleteSaleGood(){
		String ids[] = goodId.split(", ");
		
		// 查询出销售单
		Sale sale = saleService.get(Sale.class, model.getId());
		Set<SaleGoods> saleGoods = sale.getSaleGoods();
		for (String id : ids) {
			for (Iterator<SaleGoods> iterator = saleGoods.iterator(); iterator.hasNext();) {
				SaleGoods saleGood = (SaleGoods) iterator.next();
				if (saleGood.getId().equals(id)) {
					iterator.remove();
					saleGoodsService.deleteById(SaleGoods.class, saleGood.getId());
				}
			}
		}
		sale.setSaleGoods(saleGoods);
		saleService.saveOrUpdate(sale);
		super.put("results", saleGoods);
		//调用业务方法，实现批量删除
		//saleGoodsService.delete(SaleGoods.class, ids);
		
		// 查询出所有商品
		List<Good> goods = goodService.find("from Good where delFlag=0", Good.class, null);
		super.put("goods", goods);
	}

	/**
	 * 保存
	 */
	public String insert() throws Exception {
		return "alist";
	}

	/**
	 * 进入修改页面
	 */
	public String toupdate() throws Exception {
		// 查询出销售单
		Sale sale = saleService.get(Sale.class, model.getId());	
		// 得到该销售单下原有的货物
		pageGoods = sale.getSaleGoods();
		super.put("results", pageGoods);
		return "toupdate";
	}

	/**
	 * 修改
	 */
	public String update() throws Exception {

		return "alist";
	}

	/**
	 * 删除
	 */
	public String delete() throws Exception {
		String ids[] = model.getId().split(", ");
		
		//调用业务方法，实现批量删除
		saleService.delete(Sale.class, ids);
		return "alist";
	}
}
