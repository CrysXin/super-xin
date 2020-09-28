/* eslint-disable vue/require-v-for-key */
<template>
  <div>
	<p>
		<button @click="list()" class="btn btn-white btn-default btn-round">
			<i class="ace-icon fa fa-refrush red2"></i>
				刷新											
		</button>&nbsp;
			<button @click="add()" class="btn btn-white btn-default btn-round">
			<i class="ace-icon fa fa-edit red2"></i>
				新增											
		</button>
	</p>	
	<pagination ref="pagination" v-bind:list="list"></pagination>						
	<table id="simple-table" class="table  table-bordered table-hover">
											<thead>
												<tr>
													<th>Id</th>
													<th>课程</th>
													<th>课程Id</th>
													<th>操作</th>
												</tr>
											</thead>
											<tbody>
												<tr v-for="chapter in chapters" :key="chapter">
													<td>{{chapter.id}}</td>
													<td>{{chapter.name}}</td>
													<td>{{chapter.courseId}}</td>
													<td>
														<div class="hidden-sm hidden-xs btn-group">
															<button @click="edit(chapter)" class="btn btn-xs btn-info">
																<i class="ace-icon fa fa-pencil bigger-120"></i>
															</button>
															<button @click="del(chapter.id)" class="btn btn-xs btn-danger">
																<i class="ace-icon fa fa-trash-o bigger-120"></i>
															</button>	
														</div>
													</td>
												</tr>
												<tr>	
													<td>111</td>
													<td>222</td>
													<td>333</td>
												
												</tr>
											</tbody>


	</table>
		<div id="form-modal" class="modal fade" tabindex="-1" role="dialog">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">表单</h4>
      </div>
      <div class="modal-body">
		<!-- ----------from--------------- -->
		<form class="form-horizontal">
  <div class="form-group">
    <label  class="col-sm-2 control-label">名称</label>
    <div class="col-sm-10">
      <input v-model="chapter.name" class="form-control"  placeholder="名称">
    </div>
  </div>
  <div class="form-group">
    <label  class="col-sm-2 control-label">课程Id</label>
    <div class="col-sm-10">
      <input  v-model="chapter.courseId" class="form-control"  placeholder="课程Id">
    </div>
  </div>
 
</form>

		<!-- ----------from- ------------- -->
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary" @click="save()">保存</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->							
  </div>					
</template>
<script>
import Pagination from '../../components/pagination.vue'
export default {
  components: {Pagination},
  name: 'chapter',
  data:function() {
	return {
		chapters:[],
		chapter:{}
  }
},
  mounted(){
	let _this =this 
	_this.list(1)
	// this.$parent.activeSidebar('business-chapter-sidebar')
  },
 methods:{
	/**
	 * 新增
	 */
	save(){
		let _this =this 
		// 保存校验
			if (!Validator.require(_this.chapter.name, "名称")||!Validator.require(_this.chapter.courseId, "课程Id")|| !Validator.length(_this.chapter.courseId, "课程ID", 1, 8)) {
			return;
			}

		Loading.show()
		_this.$axios.post("http://127.0.0.1:9000/business/admin/chapter/save",_this.chapter
		).then(res=>{
			Loading.hide()
			console.log("保存大章结果: "+res)
			let resp = res.data
			if(resp.success){
			$("#form-modal").modal("hide")
				_this.list(1)
				Toast.success("保存成功")
			}else{
				Toast.warning(resp.message);
			}
		})
	},

	/**
	 * 查询列表
	 */
	list(page){
		let _this =this 
		_this.$axios.post("http://127.0.0.1:9000/business/admin/chapter/list",
		{
			page:page,
			size: _this.$refs.pagination.size
		}).then(res=>{
			console.log(res)
			let resp = res.data
			_this.chapters=resp.content.list
			_this.$refs.pagination.render(page, resp.content.total);
		})
	},

	/**
	 * 模态框
	 */
	add(){
		let _this =this 
		$("#form-modal").modal("show")
	},

	/**
	 * 修改
	 */
	edit(chapter) {
        let _this = this;
        _this.chapter = $.extend({}, chapter);
        $("#form-modal").modal("show");
      },

	/**
	 * s删除
	 */
	del(id){
		let _this =this 	
		Confirm.show("删除大章后不可恢复,请确认!",function(){
			Loading.show()
				_this.$axios.delete("http://127.0.0.1:9000/business/admin/chapter/delete/"+id).then(res=>{
					Loading.hide()
					let resp = res.data
					if(resp.success){
						_this.list(1)
						Toast.success("删除成功")
					}
				})
				
			
		})
		// Swal.fire({
		// 	title: '确定要删除吗?',
		// 	text: "删除后不可恢复,请确认!",
		// 	type: 'warning',
		// 	showCancelButton: true,
		// 	confirmButtonColor: '#3085d6',
		// 	cancelButtonColor: '#d33',
		// 	confirmButtonText: '确认'
		// 	}).then((result) => {
		// 		if (result.value) {
		// 			_this.$axios.delete("http://127.0.0.1:9000/business/admin/chapter/delete/"+id).then(res=>{
		// 				let resp = res.data
		// 				if(resp.success){
		// 					_this.list(1)
		// 					Toast.success("删除成功")
		// 				}
			
		// 			})
				
		// 		}
		// 	})
	},


 }
}
</script>