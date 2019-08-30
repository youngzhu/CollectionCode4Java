# 1. Rely on Interfaces, not Implementations

> Program to an interface, not an implementation.
> - Eric Gamma

面向接口编程。

For example,

	public ArrayList<String> getList() {
		return new ArrayList<String>();
	}
	
	public List<String> getList() {
		return new ArrayList<String>();
	}
	
	Do not use ArrayList, use List.
	
# 2. The Open/Closed Principle

> Classes should be open for extension, but closed for modification.

Ways of extension:

- Inheritance
	e.g. Template Pattern
- Delegation（代理）
	e.g. Observer, MVC, Chain of Responsibility
- Composition
	e.g. Strategy Pattern
	
# 3. Principle of Least Knowledge

> Only talk to friends, don't talk to strangers.

For example,

	int pageNumber = document.getCurrentPage().getPageNumber();
	
	int pageNumber = document.getCurrentPageNumber();
	
# 4. 依赖反转（Dependency Inversion）

> Depend on abstractions, never on details

For example,
需要设计一个文字处理工具（word processor），需要有两个基本的类：Document and Page。

|INTERFACE | IMPLEMENTATION |
Document | DocumentImpl
Page | PageImpl

Document 或者 DocumentImpl 应该依赖于 Page， 而不是 PageImpl 。

# 5. The HollyWood Principle

> Don't call us, we'll call you.

For example,

The Page wants to know when the Document is changed in some way.
In order to get this information the Page **should not** called the Document.
Instead the Document notifies the Page of changes when they occur - via events or messages.


	