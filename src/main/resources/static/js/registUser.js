//<![CDATA[ js代码
$("form").bootstrapValidator({
    // 指定不验证的情况
    // 值可设置为以下三种类型：
    // 1、String  ':disabled, :hidden, :not(:visible)'
    // 2、Array  默认值  [':disabled', ':hidden', ':not(:visible)']
    // 3、带回调函数  
    //  [':disabled', ':hidden', function($field, validator) {
            // $field 当前验证字段dom节点
            // validator 验证实例对象 
            // 可以再次自定义不要验证的规则
            // 必须要return，return true or false; 
    //        return !$field.is(':visible');
    //    }]
    // 
    excluded: [':disabled', ':hidden', ':not(:visible)'],
    // 生效规则
    // enabled:字段值发生变化就触发验证
    // disabled/submitted:点击提交时触发验证
    live: 'enabled',
    // 图标 
    feedbackIcons: {
        valid: 'glyphicon glyphicon-ok',
        invalid: 'glyphicon glyphicon-remove', 
        validating: 'glyphicon glyphicon-refresh'
    },
    fields: {
    	uname: { // name属性值
    	    validators: {
    	        notEmpty: { // 非空校验
    	            message: '用户名不能为空!'
    	        },
			    stringLength: { // 长度校验
			        min: 6,
			        max: 10,
			        message: '用户名长度%s~%s个字符！'
			    }    
    
    	    }
    	},
    	pass: {
    	    validators: {
    	        notEmpty: {
    	            message: '请输入密码'
    	        },
    	        different: { // 比较是否不同，否的话校验不通过
    	            field: 'uname', // 和userName字段比较
    	            message: '密码不能与用户名相同！'	
    	        },
    	        stringLength: { // 长度校验
			        min: 6,
			        max: 20,
			        message: '密码长度%s~%s个字符！'
			    }        
    	    }
    	}
    }
});
//]]>