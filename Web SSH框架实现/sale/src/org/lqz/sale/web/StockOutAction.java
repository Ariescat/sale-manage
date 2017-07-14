package org.lqz.sale.web;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.lqz.sale.domain.Good;
import org.lqz.sale.domain.Stock;
import org.lqz.sale.domain.StockGoods;
import org.lqz.sale.domain.User;
import org.lqz.sale.service.GoodService;
import org.lqz.sale.service.StockGoodsService;
import org.lqz.sale.service.StockService;
import org.lqz.sale.utils.Page;

import com.opensymphony.xwork2.ModelDriven;

public class StockOutAction extends BaseAction implements ModelDriven<Stock> {

	private static final long serialVersionUID = 2207130521096906276L;
	private Stock model = new Stock();

	@Override
	public Stock getModel() {
		return model;
	}

	// 分页查询
	private Page<Stock> page = new Page<Stock>();
	public Page<Stock> getPage() {
		return page;
	}
	public void setPage(Page<Stock> page) {
		this.page = page;
	}
	
	// 网页中商品名称和数量的属性[表格上方的两个表单]
	private StockGoods stockGood;
	public void setStockGood(StockGoods stockGood) {
		this.stockGood = stockGood;
	}
	public StockGoods getStockGood() {
		return stockGood;
	}
	
	// 网页中添加的商品[表格中用]
	private Set<StockGoods> pageGoods = new HashSet<StockGoods>();
	public void setPageGoods(Set<StockGoods> pageGoods) {
		this.pageGoods = pageGoods;
	}
	
	// 服务层
	private StockService stockService;
	public void setStockService(StockService stockService) {
		this.stockService = stockService;
	}
	private GoodService goodService;
	public void setGoodService(GoodService goodService) {
		this.goodService = goodService;
	}
	private StockGoodsService stockGoodsService;
	public void setStockGoodsService(StockGoodsService stockGoodsService) {
		this.stockGoodsService = stockGoodsService;
	}
	
	/**
	 * 分页查询 出库 sign=1
	 */
	public String list() throws Exception {
		String hql = "from Stock where sign=1";

		stockService.findPage(hql, page, Stock.class, null);

		// 设置分页的url地址
		page.setUrl("StockAction_list");

		// 将page对象压入栈顶
		super.push(page);
		return "list";
	}

	/**
	 * 查看
	 */
	public String toview() throws Exception {
		// 1.调用业务方法，根据id,得到对象
		Stock stock = stockService.get(Stock.class, model.getId());

		// 放入栈顶
		super.push(stock);

		// 3.跳页面
		return "toview";
	}

	/**
	 * 进入新增页面
	 */
	public String tocreate() throws Exception {
		// 1.创建一个新订单
		User curUser = super.getCurUser();
		model.setId(null);
		model.setHandler(curUser);
		model.setDelFlag(0);
		// 出库
		model.setSign(1);
		stockService.saveOrUpdate(model);
		super.push(model);
		
		// 2.查询出所有商品
		List<Good> goods = goodService.find("from Good where delFlag=0", Good.class, null);
		super.put("goods", goods);
		
		return "tocreate";
	}
	
	/**
	 * 为库存表添加一条记录
	 * @return
	 */
	public String addOneGood(){
		// 查询出入库单
		Stock stock = stockService.get(Stock.class, model.getId());
		
		// 查询出新增的货物
		Good good = goodService.get(Good.class, stockGood.getGood().getId());
		
		stockGood.setId(null);
		stockGood.setStock(stock);
		stockGood.setGood(good);
		stockGood.setGoodName(good.getName());
		
		// 得到该销售单下原有的货物
		pageGoods = stock.getStockGoods();
		// 添加一条货物
		pageGoods.add(stockGood);
		stock.setStockGoods(pageGoods);
		
		// 保存销售单
		stockService.saveOrUpdate(stock);
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
	public String deleteStockGood_fromCreate(){
		deleteSaleGood();
		return "tocreate";
	}
	public String deleteStockGood_fromUpdate(){
		deleteSaleGood();
		return "toupdate";
	}
	private void deleteSaleGood(){
		String ids[] = goodId.split(", ");
		
		// 查询出入库单
		Stock stock = stockService.get(Stock.class, model.getId());
		
		//调用业务方法，实现批量删除
		for (String id : ids) {
			stockGood = stockGoodsService.get(StockGoods.class, id);
			stock.getStockGoods().remove(stockGood);
			stockService.saveOrUpdate(stock);
		}
		super.put("results", stock.getStockGoods());
		
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
		Stock stock = stockService.get(Stock.class, model.getId());	
		// 得到该销售单下原有的货物
		pageGoods = stock.getStockGoods();
		super.put("results", pageGoods);
		return "toupdate";
	}
	
	/**
	 * 修改
	 */
	public String update() throws Exception {
		// 查询出销售单
		Stock stock = stockService.get(Stock.class, model.getId());	
		// 得到该销售单下原有的货物
		Set<StockGoods> stockGoods = stock.getStockGoods();
		super.put("results", stockGoods);
		return "alist";
	}

	/**
	 * 删除
	 */
	public String delete() throws Exception {
		String ids[] = model.getId().split(", ");
		
		//调用业务方法，实现批量删除
		stockService.delete(Stock.class, ids);
		return "alist";
	}
}
